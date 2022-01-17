import React from 'react';
import RaisedButton from 'material-ui/RaisedButton';
import {Toolbar, ToolbarGroup} from 'material-ui/Toolbar';
import FlatButton from 'material-ui/FlatButton';
import {connect} from 'react-redux';
import {Link, withRouter} from 'react-router-dom';
import logo from './logo.png';
import '../../style.css';
import qs from 'query-string';

const labelStyles = {
  textTransform: 'capitalize'
}

class Navbar extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      query: ''
    }
  }

  handleSearch = (e) => {
    const query = e.currentTarget.value;
    this.setState({query: query});
  }

  handleSubmit = (e) => {
    e.preventDefault();
    console.log(this.state);
    const restaurants = this.props.restaurants;
    this.props.history.push({pathname: '/search', search: qs.stringify({query: this.state.query})})
    //try to do the same on hitting enter not just click on the searchButton
    this.setState({query: ''});
    }

  render() {
    return (
      <div>
        <Toolbar className="Navbar">

          <ToolbarGroup firstChild={true}>
            <Link to="/">
              <img src={logo} className="Yelp-logo" alt="logo"/>
            </Link>
            <div className="ContactButtons">
              <Link to="/about">
                <FlatButton label="About" className="redBackground" labelStyle={labelStyles}/>
              </Link>
              <Link to="/contact">
                <FlatButton label="Contact" className="redBackground" labelStyle={labelStyles}/>
              </Link>
            </div>
            <form onSubmit= {this.handleSubmit}>
              <input placeholder="Type a restaurant name" onChange={this.handleSearch} value={this.state.query}/>
              <RaisedButton onClick={this.handleSubmit} label="Search" className="searchButton" labelStyle={labelStyles} style={{
                'height': 24
              }}/>
            </form>
          </ToolbarGroup>

          <ToolbarGroup >
            <div className="SignButtons">
              <Link to="/users/sign_in">
                <FlatButton label="Sign In" primary={true} className="redBackground" labelStyle={labelStyles}/>
              </Link>
              <Link to="/users/sign_up">
                <FlatButton label="Sign Up" secondary={true} className="redBackground" labelStyle={labelStyles}/>
              </Link>
            </div>
          </ToolbarGroup>

        </Toolbar>
        {this.props.children}
      </div>
    );
  }
}

const mapStateToProps = (state) => ({restaurants: state.restaurants});

export default connect(mapStateToProps)(withRouter(Navbar));
