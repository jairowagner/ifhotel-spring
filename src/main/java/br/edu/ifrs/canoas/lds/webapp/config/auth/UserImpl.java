package br.edu.ifrs.canoas.lds.webapp.config.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import br.edu.ifrs.canoas.lds.webapp.domain.Usuario;

public class UserImpl extends org.springframework.security.core.userdetails.User{

	private static final long serialVersionUID = 1308839480601748734L;

	private Usuario usuario;

    public UserImpl(String username, String password, Collection<? extends GrantedAuthority> authorities, Usuario usuario) {
        super(username, password, authorities);
        this.usuario = usuario;
    }

    public UserImpl(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public UserImpl(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public Usuario getUser() {
        return usuario;
    }
}
