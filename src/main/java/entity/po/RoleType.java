package entity.po;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;

@Entity
@Data
@ToString(exclude = {"cRoleType", "info"})
public class RoleType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer rid;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "pid",
            foreignKey = @ForeignKey(name = "pid"))
    private RoleType pid;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "pid")
    private Set<RoleType> cRoleType;

    @Column(length = 32, nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_group",
            foreignKey = @ForeignKey(name = "role_group"))
    private Group group;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "RoleTypeInfo",
            joinColumns = @JoinColumn(name = "rid",
                    foreignKey = @ForeignKey(name = "info_role_id"))
    )

    @Column(name = "value", length = 64)
    @MapKeyJoinColumn(name = "tid", referencedColumnName = "tid")
    private Map<InfoType, String> info;

}
