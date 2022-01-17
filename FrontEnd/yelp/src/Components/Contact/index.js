import React, { Component } from 'react';
import '../../style.css';

class Contact extends Component {
  render() {
    return (
      <div>
          <div className="ContactCombineElements">
            <h3> We would love to hear from you!</h3>
            <p className="Contact-email">
            Contact us at <a href= {'#'}>thisleadsnowehre@yelpexample.com</a>
            </p>
          </div>
      </div>
    );
  }
}

export default Contact;
