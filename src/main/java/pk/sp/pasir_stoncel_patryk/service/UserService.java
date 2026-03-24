package pk.sp.pasir_stoncel_patryk.service;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pk.sp.pasir_stoncel_patryk.exception.UserAlreadyExistsException;
import pk.sp.pasir_stoncel_patryk.security.JwtUtil;
import pk.sp.pasir_stoncel_patryk.dto.LoginDto;
import pk.sp.pasir_stoncel_patryk.dto.UserDto;
import pk.sp.pasir_stoncel_patryk.model.User;
import pk.sp.pasir_stoncel_patryk.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public UserService(UserRepository userRepository, PasswordEncoder encoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.jwtUtil = jwtUtil;
    }

    public User register(UserDto dto) {
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("użytkownik z tym adresem e-mail już istnieje");
        }
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(encoder.encode(dto.getPassword()));
        return userRepository.save(user);
    }

    public String login(LoginDto dto) {
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Nie znaleziono użytkownika"));
        if (!encoder.matches(dto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Nieprawidłowe dane logowania");
        }
        return jwtUtil.generateToken(user.getEmail());
    }
}

