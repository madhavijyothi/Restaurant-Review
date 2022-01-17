import React from 'react';
import ReactDOM from 'react-dom';
import registerServiceWorker from './registerServiceWorker';
import './index.css';
import {Provider} from 'react-redux';
import store from './Store';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import injectTapEventPlugin from 'react-tap-event-plugin';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import Home from './Routes/Home';
import Contact from './Routes/Contact';
import About from './Routes/About';
import Restaurant from './Routes/Restaurant';
import Navbar from './Containers/Navbar';
import Search from './Routes/Search';
import Login from './Containers/Login';
import SignUp from './Containers/SignUp';
import AddReview from './Containers/AddReview';

injectTapEventPlugin();

// MuiThemeProvider needs to be the outermost for the routing to work correctly

ReactDOM.render(
  <MuiThemeProvider>
  <Provider store={store}>
    <Router>
      <Switch>
        <Navbar>
          <Route exact path="/" component={Home} />
          <Route exact path="/contact" component={Contact} />
          <Route exact path="/about" component={About} />
          <Route exact path="/restaurant/:restaurant_id" component={Restaurant} />
          <Route exact path="/search" component={Search} />
          <Route exact path="/users/sign_in" component={Login} />
          <Route exact path="/users/sign_up" component={SignUp} />
          <Route exact path="/restaurant/:restaurant_id/reviews/new" component={AddReview} />
        </Navbar>
      </Switch>
    </Router>
  </Provider>
</MuiThemeProvider>, document.getElementById('root'));

registerServiceWorker();
