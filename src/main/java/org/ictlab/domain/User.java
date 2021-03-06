package org.ictlab.domain;

import com.fasterxml.jackson.annotation.*;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "APPUSER")
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appuser_seq")
    @SequenceGenerator(name = "appuser_seq", sequenceName = "appuser_seq", allocationSize = 1)
    private Long id;

    @Column(name = "USERNAME", length = 50, unique = true)
    @NotNull
    private String username;

    @Column(name = "PASSWORD")
    @NotNull
    @Size(min = 4)
    private String password;

    @Column(name = "FIRSTNAME", length = 50)
    @NotNull
    private String firstname;

    @Column(name = "LASTNAME", length = 50)
    @NotNull
    private String lastname;

    @Column(name = "EMAIL", length = 50)
    @NotNull
    private String email;

    @Column(name = "ENABLED")
    @NotNull
    private Boolean enabled;

    @Column(name = "LASTPASSWORDRESETDATE")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date lastPasswordResetDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "APPUSER_AUTHORITY",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID")})
    @JsonIgnoreProperties("users")
    private List<Authority> authorities;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "APPUSER_MESSAGE",
        joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
        inverseJoinColumns = {@JoinColumn(name = "MESSAGE_ID", referencedColumnName = "ID")})
    private List<Message> messages;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "APPUSER_RESERVATION",
        joinColumns = {@JoinColumn(name = "RESERVATION_ID", referencedColumnName = "ID")},
        inverseJoinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")})
    @JsonIgnoreProperties("users")
    private List<Reservation> reservations;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CLASS_ID")
    private Group className;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Group getClassName() {
        return className;
    }

    public void setClassName(Group className) {
        this.className = className;
    }
}
