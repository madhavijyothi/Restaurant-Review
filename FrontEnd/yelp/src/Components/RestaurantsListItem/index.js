import React from 'react';
import {
  TableRow,
  TableRowColumn
} from 'material-ui/Table';

const  RestaurantsListItem = (props) => {
  return (
          <TableRow>
            <TableRowColumn>{props.restaurant.name}</TableRowColumn>
            <TableRowColumn>{props.restaurant.address}</TableRowColumn>
            <TableRowColumn>{props.restaurant.phone}</TableRowColumn>
            <TableRowColumn>
              <a href ={props.restaurant.web} rel="noopener norefferer" target="_blank" >{props.restaurant.web}</a>
            </TableRowColumn>
          </TableRow>
          )
};


export default RestaurantsListItem;
