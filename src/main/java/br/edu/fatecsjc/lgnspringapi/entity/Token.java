package br.edu.fatecsjc.lgnspringapi.entity;

import br.edu.fatecsjc.lgnspringapi.enums.TokenType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tokens")
public class Token {

    @Id
    @SequenceGenerator(initialValue = 1, allocationSize = 1, name = "tokensidgen", sequenceName = "tokens_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tokensidgen")
    public Long id;

    @Column(unique = true)
    public String token;

    @Enumerated(EnumType.STRING)
    public TokenType tokenType = TokenType.BEARER;

    public boolean revoked;

    public boolean expired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User user;
}
