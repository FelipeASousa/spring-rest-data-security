package br.edu.fatecsjc.lgnspringapi.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @SequenceGenerator(initialValue = 1, allocationSize = 1, name = "groupsidgen", sequenceName = "groups_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "groupsidgen")
    private Long id;
    private String name;
    @OneToMany(mappedBy="group", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Member> members;
}
