package net.dodian.orm.models.character

import org.springframework.beans.BeansException
import org.springframework.beans.factory.BeanFactory
import org.springframework.beans.factory.BeanFactoryAware
import javax.persistence.*

@Entity
@Table(name = "characters", uniqueConstraints = [UniqueConstraint(columnNames = arrayOf("username"))])
class Character() : BeanFactoryAware {
    @Transient
    private var beanFactory: BeanFactory? = null

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0

    @Column(nullable = false)
    var userId = 0
    var username: String? = null
    var isOnline = false
    var posX = 0
    var posY = 0
    var level = 0

    @Column(columnDefinition = "double precision default 100.0")
    var runEnergy = 0.0

    @Embedded
    var experience: CharacterExperience? = null

    @Embedded
    private var levels: CharacterLevels? = null

    @Throws(BeansException::class)
    override fun setBeanFactory(beanFactory: BeanFactory) {
        this.beanFactory = beanFactory
    }
}
