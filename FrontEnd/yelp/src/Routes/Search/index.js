import React, {Component} from 'react';
import {connect} from 'react-redux';
import RestaurantsList from '../../Containers/RestaurantsList';


class Search extends Component {
  constructor(props){
    super(props);

    this.state = {
      restaurants: {},
    };
  }
  componentDidMount(){

  }
  render(){
    return(
      // <RestaurantsList restaurants={this.state.restaurants}/>
      <RestaurantsList/>
    );
  }
}


export default connect()(Search);
