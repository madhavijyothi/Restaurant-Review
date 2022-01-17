import React from 'react';
import {
  Table,
  TableBody,
  TableRow,
  TableRowColumn,
} from 'material-ui/Table';
import '../../style.css';
import StarBorder from 'material-ui/svg-icons/toggle/star-border';
import Star from 'material-ui/svg-icons/toggle/star';

class ReviewsList extends React.Component {
  
  starsRender = (rate) => {
    let stars=[];
    for (let i=1; i<=5; i++) {
      if (i <= rate) { 
        stars.push(<Star key={i} color="yellow" />) 
      } else {
        stars.push(<StarBorder key={i} color="grey" />)  
      }
    }
    return <div>{stars}</div>;
  }

  initial = (lastName) => {
    lastName.split("");
    return lastName[0];
  }

  render() {
    // extra variables
    const reviews = this.props.reviews; // array of reviews

    return (
      <Table selectable={false} className="ReviewsTable" >

        <TableBody displayRowCheckbox={false}>
        {reviews.map((review) => {
          return <TableRow className="ReviewsListItem" key={review.id} >
            <TableRowColumn><b>{review.user.firstName} {this.initial(review.user.lastName)}. </b><br/><br/> {review.created_at} </TableRowColumn>
            <TableRowColumn> {this.starsRender(review.rate)} <br/><br/> {review.content} </TableRowColumn>
          </TableRow>
        })};
        </TableBody>

      </Table>
    );
  }

}

export default ReviewsList;
