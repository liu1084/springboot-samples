package cn.g2link.web.reports.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "r_roles")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @Column(name = "parent_id")
    private Integer parentId;
    private String description;
}
