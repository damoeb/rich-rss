package org.migor.rss.rich.model

import org.hibernate.annotations.GenericGenerator
import org.migor.rss.rich.dto.UserDto
import java.util.*
import javax.persistence.*


@Entity
@Table(name = "t_user")
class User {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  var id: String? = null

  @Column(nullable = false)
  var apiKey: String? = null

  @Column(nullable = false)
  var name: String? = null

  @Column(nullable = false)
  var emailHash: String? = null

  @Column(nullable = false)
  var points: Int = 0

  @Column(nullable = false)
  var description: String? = null

  @Column(nullable = false)
  var readPolicy = ReadPolicy.READER

  @OneToMany(targetEntity = Subscription::class, mappedBy = "owner", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = true)
  var subscriptions: List<Subscription> = ArrayList()

  @OneToMany(targetEntity = Feed::class, mappedBy = "owner", cascade = [CascadeType.ALL], fetch = FetchType.EAGER, orphanRemoval = true)
  var feeds: List<Feed> = ArrayList()

  @Basic
  var createdAt = Date()

  fun toDto() = UserDto(id, emailHash, name, description, createdAt, feeds.sortedBy { feed: Feed -> feed.priority }.map { feed: Feed -> feed.toDto() })
}
