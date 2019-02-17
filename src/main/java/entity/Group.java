package entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@Entity(name = "RoleGroup")
@Data
public class Group implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer gid;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pid", foreignKey = @ForeignKey(name = "pid", foreignKeyDefinition = "parent"))
    private Group pid;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pid")
    private Set<Group> cGroup;

    @Column(length = 16, nullable = false)
    private String name;

    @Column(nullable = false, updatable = false)
    private Date registerDate;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "GroupInfo",
            joinColumns = @JoinColumn(name = "gid", foreignKey = @ForeignKey(foreignKeyDefinition = "info_gid")))
    @Column(name = "value", length = 64)
    @MapKeyJoinColumn(name = "tid", referencedColumnName = "tid",
            foreignKey = @ForeignKey(foreignKeyDefinition = "info_tid"))
    private Map<InfoType, String> info;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Role> roles;
}