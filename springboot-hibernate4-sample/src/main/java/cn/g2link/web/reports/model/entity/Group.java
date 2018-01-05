package cn.g2link.web.reports.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "r_groups")
@Data
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @Column(name = "parent_id")
    private Integer parentId;
    @Column(name = "boss_id")
    private Integer bossId;
}
