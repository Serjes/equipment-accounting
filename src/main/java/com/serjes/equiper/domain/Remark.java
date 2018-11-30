package com.serjes.equiper.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Discussions")
public class Remark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name="content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
