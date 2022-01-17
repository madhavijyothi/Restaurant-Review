import React, {Component} from 'react';
import {connect} from 'react-redux';
import GoogleMapReact from 'google-map-react';
import './style.css'

const Marker = ({text}) => <div className="Map-Marker-Circle">{text}</div>;

class Map extends Component {

  constructor(props) {
    super(props);
    this.state = {}
  }

  componentDidMount() {
    // address for test purpose taken from the array[0], has to be changed when implemented on the restaurant page
    const address = this.props.address;
    let url = `https://maps.googleapis.com/maps/api/geocode/json?address=${address}&key=AIzaSyBM0Y_I8AJlpXoRzx9t6emHYJvzdk1M3LA`;

    fetch(url)
    .then((response) => {
      return response.json();
    })
    .then((data) => {
      const location = data.results[0].geometry.location;
      this.setState({
        lat: location.lat,
        lng: location.lng
      })
    });
  }

  render() {
    const center = {
      lat: this.state.lat,
      lng:this.state.lng
    };
    const name = this.props.name;
    return (
      <div className="Map-MapWindow" style={{
        width: '200px',
        height: '300px'
      }}>
      { center.lat && center.lng &&
        <GoogleMapReact
                defaultCenter={center}
                defaultZoom={12}
                >
                <Marker
                  lat={center.lat}
                  lng={center.lng}
                  text={name}
                  />
              </GoogleMapReact>
      }
      </div>
    );
  }
}

const mapStateToProps = (state) => ({restaurants: state.restaurants});
export default connect(mapStateToProps)(Map);

// (function() {
//   if(center.lat && center.lng)
//     return (
//       <GoogleMapReact
//         defaultCenter={center}
//         defaultZoom={12}
//         >
//         <Marker className="Map-Marker"
//           lat={center.lat}
//           lng={center.lng}
//           text={name}
//           />
//       </GoogleMapReact>
//  )
// })();
