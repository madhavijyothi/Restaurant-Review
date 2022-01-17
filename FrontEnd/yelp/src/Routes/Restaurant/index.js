import React, { Component } from 'react';
import RestaurantContainer from '../../Containers/Restaurant';

class Restaurant extends Component {
  render() {
    return (
        <RestaurantContainer params={this.props.match.params.restaurant_id}/>
    );
  }
}

export default Restaurant;
