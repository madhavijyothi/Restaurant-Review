import React, { Component } from 'react';
import { connect } from 'react-redux';
import '../../style.css';
import { RaisedButton } from 'material-ui';
import TextField from 'material-ui/TextField';
import ReactStars from 'react-stars'

const ratingChanged = (newRating) => {
  console.log(newRating)
}

class AddReview extends Component {

  constructor(props) {
    super(props)
    this.state = {
      content: ''
    }
  }

  handleContent = (e) => { this.setState({ content: e.currentTarget.value }); };

  render() {
    let restaurantName;
    for (let i=0; i<this.props.restaurants.length; i++) {
      if (this.props.restaurants[i].id === this.props.match.params.restaurant_id * 1) {
        restaurantName = this.props.restaurants[i].name;
      }
    }

    return (
      <div className="AddReview">
        <h3>Add a new review for {restaurantName}:</h3>
        <div className="reviewStars">
          <ReactStars count={5} onChange={ratingChanged} size={30}  color2={'#ffd700'} half={false} />
        </div> 
        <form className="AddReviewForm">
          <TextField hintText="Share your experience" onChange={ this.handleContent }/> <br />
          <RaisedButton type="submit" label="Add review" />
        </form>
      </div>
    );
  }
}

const mapStateToProps = (state) => {
  return state;
}

export default connect(mapStateToProps)(AddReview);