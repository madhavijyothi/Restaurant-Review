import React, { Component } from 'react';
import { connect } from 'react-redux';
import { Link } from 'react-router-dom';

import '../../style.css';

import { RaisedButton } from 'material-ui';
import TextField from 'material-ui/TextField';

class Login extends Component {

  constructor(props) {
    super(props)
    this.state = {
      email: '',
      password: ''
    }
  }

  handleEmail = (e) => {
    const email = e.currentTarget.value;
    this.setState({ email });
  };
  handlePassword = (e) => {
    const password = e.currentTarget.value;
    this.setState({ password });
  };
  
  render() {
    return (
      <div className="SignIn">
        <br/>
        <form>
          <TextField hintText="E-mail" onChange={ this.handleEmail }/>
          <br />
          <TextField hintText="Password" floatingLabelText="Password" type="password" onChange={ this.handlePassword }/>
          <br /><br /><br />
          <RaisedButton type="submit" label="Sign In" />
        </form><br/>
        <p>If you don´t have an user, you can register <Link to="/users/sign_up">here</Link> </p>
      </div>
    );
  }
}

const mapStateToProps = (state) => {
  return state;
}

export default connect(mapStateToProps)(Login);