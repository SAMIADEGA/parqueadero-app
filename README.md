package co.edu.iudigital.parqueadero.parqueaderoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import co.edu.iudigital.parqueadero.parqueaderoapp.domain.Usuario;
import co.edu.iudigital.parqueadero.parqueaderoapp.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registro")
    @ResponseStatus(HttpStatus.CREATED)
    public void registroUsuario(@RequestBody Usuario usuario) {
        usuarioService.registrarUsuario(usuario);
    }

    @PostMapping("/autenticacion")
    public boolean autenticarUsuario(@RequestParam String nombreUsuario, @RequestParam String contrasena) {
        return usuarioService.autenticarUsuario(nombreUsuario, contrasena);
    }

    @PutMapping("/actualizar-perfil/{idUsuario}")
    @ResponseStatus(HttpStatus.CREATED)
    public void actualizarPerfil(@PathVariable("idUsuario") Long idUsuario, @RequestBody Usuario usuario) {
        usuarioService.actualizarPerfil(idUsuario, usuario);
    }

    @PutMapping("/cambiar-contrasena/{idUsuario}")
    @ResponseStatus(HttpStatus.CREATED)
    public void cambiarContrasena(@PathVariable("idUsuario") Long idUsuario, @RequestParam String nuevaContrasena) {
        usuarioService.cambiarContrasena(idUsuario, nuevaContrasena);
    }

    @GetMapping("/actividades/{idUsuario}")
    public List<String> obtenerRegistroActividades(@PathVariable("idUsuario") Long idUsuario) {
        return usuarioService.obtenerRegistroActividades(idUsuario);
    }
}
