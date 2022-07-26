/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.francovico.Security.Controller;

import com.portfolio.francovico.Security.DTO.JWTDTO;
import com.portfolio.francovico.Security.DTO.LoginUsuario;
import com.portfolio.francovico.Security.DTO.NuevoUsuario;
import com.portfolio.francovico.Security.Entity.Rol;
import com.portfolio.francovico.Security.Entity.Usuario;
import com.portfolio.francovico.Security.Enums.RolNombre;
import com.portfolio.francovico.Security.JWT.JWTProvider;
import com.portfolio.francovico.Security.Service.RolService;
import com.portfolio.francovico.Security.Service.UsuarioService;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Autor Franco Vico - Backend para Argentina Programa
 */

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins ="https://portfolio-fe-francovico.herokuapp.com")
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RolService rolService;
    @Autowired
    JWTProvider JWTProvider;
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos erroneos"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existsbyNombreUsuario(nuevoUsuario.getNombreUsuario()))
            return new ResponseEntity(new Mensaje("Usuario ya existe"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existsbyEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity(new Mensaje("Email ya existe"), HttpStatus.BAD_REQUEST);
        
        Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));
    
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        return new ResponseEntity(new Mensaje("Nuevo usuario creado"),HttpStatus.CREATED);       
    }
    
    @PostMapping("/login")
    public ResponseEntity<JWTDTO> login (@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Error en campos"), HttpStatus.BAD_REQUEST);
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
    
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String JWT = JWTProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JWTDTO JWTDTO = new JWTDTO(JWT, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(JWTDTO, HttpStatus.OK);
    }
}
