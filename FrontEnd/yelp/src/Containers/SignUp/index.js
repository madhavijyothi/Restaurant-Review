import React, { Component } from 'react';
import { connect } from 'react-redux';

import '../../style.css';

import { RaisedButton } from 'material-ui';
import TextField from 'material-ui/TextField';

class SignUp extends Component {

  constructor(props) {
    super(props)
    this.state = {
      firstName: '',
      lastName: '',
      email: '',
      password: '',
      passwordRepeat: '',
    }
  }

  handleFirstName = (e) => { this.setState({ firstaName: e.currentTarget.value }); };
  handleLastName = (e) => { this.setState({ lastaName: e.currentTarget.value }); };
  handleEmail = (e) => { this.setState({ email: e.currentTarget.value }); };
  handlePassword = (e) => { this.setState({ password: e.currentTarget.value }); };
  handlePasswordRepeat = (e) => { this.setState({ passwordRepeat: e.currentTarget.value }); };
  
  render() {
    return (
      <div className="SignUp">
        <h3>Fill out the following information to start rating your favorites restaurants! </h3>
        <form className="SignUpForm">
          <TextField hintText="First Name" onChange={ this.handleLastName }/> <br />
          <TextField hintText="Last Name" onChange={ this.handleLastName }/> <br />
          <TextField hintText="Email" onChange={ this.handleEmail }/> <br />
          <TextField hintText="Password" type="password" onChange={this.handlePassword }/><br />
          <TextField hintText="Enter your password again" type="password" onChange={this.handlePasswordRepeat }/><br /><br />
          <RaisedButton type="submit" label="Register" />
        </form>
      </div>
    );
  }
}

const mapStateToProps = (state) => {
  return state;
}

export default connect(mapStateToProps)(SignUp);