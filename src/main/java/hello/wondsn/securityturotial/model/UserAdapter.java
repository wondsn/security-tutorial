package hello.wondsn.securityturotial.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UserAdapter implements UserDetails {

    private final String username;
    private final String password;
    private final String authorities;

    public UserAdapter(Member member) {
        this.username = member.getUsername();
        this.password = member.getPassword();
        this.authorities = member.getRole();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> authorties = new ArrayList<>();
        authorties.add(new SimpleGrantedAuthority(authorities));
        return authorties;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
