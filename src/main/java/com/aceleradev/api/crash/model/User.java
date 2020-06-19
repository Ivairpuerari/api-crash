package com.aceleradev.api.crash.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USUARIO")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements UserDetails {

    private static final long serialVersionUID = 6051363659459864997L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USE_ID")
    private Long id;

    @Column(name = "USE_NOMECOMPLETO")
    private String nomeCompleto;

    @Column(name = "USE_EMAIL")
    private String email;

    @Column(name = "USE_PASSWORD")
    private String password;

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinColumn(name = "USE_ID")
    @JsonManagedReference
    private final List<Permissao> permissoes = new ArrayList<>();

    @Column(name = "USE_DATA")
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dataCriacao;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.permissoes.stream().map(parametro -> new SimpleGrantedAuthority(parametro.getValor()))
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    public void setPermissões(List<Permissao> permissoes) {
        this.permissoes.clear();

        Optional.ofNullable(permissoes).ifPresent(permissao -> this.permissoes.addAll(permissao));

        if (permissoes != null) {
            this.permissoes.addAll(permissoes);
        }
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