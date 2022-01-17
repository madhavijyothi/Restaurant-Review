import React from 'react';
import '../../style.css';
import { connect } from 'react-redux';
import { Link } from 'react-router-dom';
import ReviewsList from '../../Components/ReviewsList';
import StarBorder from 'material-ui/svg-icons/toggle/star-border';
import HalfStar from 'material-ui/svg-icons/toggle/star-half';
import Star from 'material-ui/svg-icons/toggle/star';
import Map from '../../Components/GoogleMaps';

class Restaurant extends React.Component {

  averageCalculator = (reviews) => {
    let totalReviews = 0;
    for (let i=0; i<reviews.length; i++) {
        totalReviews += reviews[i].rate;
      }
    const average = totalReviews / reviews.length;
    return average;
  }

  averageStarsRender = (average) => {
    let stars=[];
    for (let i=1; i<=5; i++) {
      if (i <= average) {
        stars.push(<Star key={i} color="yellow" />)
      } else if (i - average > 0.01 && i - average < 0.99) {
        stars.push(<HalfStar key={i} color="yellow" />)
      } else {
        stars.push(<StarBorder key={i} color="grey" />)
      }
    }
    return <p>{stars}</p>;
  }

  render() {
    const restaurantId = this.props.params;
    // looks for restaurant info
    let restaurant = false;
    for (let i=0; i<this.props.restaurants.length; i++) {
      if (this.props.restaurants[i].id === restaurantId * 1) {
        restaurant = this.props.restaurants[i];
        break;
      }
    }
    // extra variables
    const reviews = restaurant.reviews;
    const srcText = `http://maps.google.com/maps/api/staticmap?center=${restaurant.address}&maptype=roadmap&zoom=14&size=500x350&sensor=false&maptype=HYBRID&markers=color:red|label:${restaurant.address}|${restaurant.address}`;
    const linkText = `/restaurant/${restaurantId}/reviews/new`;



    return (
      <div>
        <div className="RestaurantColumns">


          <div className="RestaurantInfo">
            <img  className="RestaurantLogo" src="http://www.echorestaurant.ch/wp-content/uploads/sites/9/2015/10/logo-echo.png" style={{"backgroundColor":"black"}}/>
            <h3>{ restaurant.name }</h3>
            <div> {this.averageStarsRender(this.averageCalculator(reviews))} </div>
            <p> {reviews.length} Reviews </p>
            <p><b>Address:</b> {restaurant.address} </p>
            <p><b>Phone: </b> {restaurant.phone} </p>
            <p><b>Website: </b> <a href={restaurant.web} target="_blank" >{restaurant.web}</a></p>
            <Link to={linkText}><button> Write a review </button></Link>
            <br/><br/>
            <Map address={restaurant.address} name={restaurant.name}/>
          </div>

          <div className="ReviewsList">
            <ReviewsList reviews={reviews} />
          </div>

        </div>
      </div>

    );
  }
}

const mapStateToProps = (state) => {
  return state;
}

export default connect(mapStateToProps)(Restaurant);
