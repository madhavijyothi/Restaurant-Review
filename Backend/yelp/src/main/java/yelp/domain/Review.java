package yelp.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@Table(name = "review")
@EqualsAndHashCode(exclude = {"id", "dateCreated"})
@ToString(exclude={"user", "restaurant"})
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
  
	@Column(name = "content", nullable = true, length = 1000)
	private String content;
  
	@Column(name = "rate", nullable = true, length = 1)
	private int rate;
  
	@Column(name = "create_at", nullable = true)
	private LocalDateTime dateCreated;

	@ManyToOne(optional=false)
	private User user;

	@ManyToOne(optional=false)
	private Restaurant restaurant;

	public Review() {
		// JPA required :)
	}

	public Review(String text, int rating, LocalDateTime dateCreated, User user, Restaurant restaurant) {
		// super();
		this.content = text;
		this.rate = rating;
		this.dateCreated = dateCreated;
		this.user = user;
		this.restaurant = restaurant;
	}
}
