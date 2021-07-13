package com.bazarek.bazarek.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "training")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_training")
    private long idTraining;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY,cascade ={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "user_training",joinColumns = @JoinColumn (name = "id_training"),inverseJoinColumns = @JoinColumn(name = "id_user"))
    private List<User> users;

    public Training(String name) {
        this.name = name;
    }

    public void addUser(User user){
        if (users == null){
            users = new ArrayList<>();
        }
        users.add(user);
    }
}
