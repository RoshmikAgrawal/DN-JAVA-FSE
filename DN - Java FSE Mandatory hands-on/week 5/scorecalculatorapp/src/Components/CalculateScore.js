import React from 'react';
import '../Stylesheets/mystyle.css';

// Pure helper function converting raw evaluations into formatted text blocks
const percentToDecimal = (decimal) => {
    return (decimal.toFixed(2) + '%');
};

// Computes the score ratio based on manual configurations
const calcScore = (total, goal) => {
    return percentToDecimal(total / goal);
};

/**
 * Functional component processing student metrics via props destructuring.
 * Renders an inline structured template utilizing external stylesheet classes.
 */
export const CalculateScore = ({ Name, School, total, goal }) => {
    return (
        <div className="formatstyle">
            <h1><font color="Brown">Student Details:</font></h1>
            <div className="Name">
                <b><span>Name: </span></b>
                <span>{Name}</span>
            </div>
            <div className="School">
                <b><span>School: </span></b>
                <span>{School}</span>
            </div>
            <div className="Total">
                <b><span>Total: </span></b>
                <span>{total}</span>
                <span>Marks</span>
            </div>
            <div className="Score">
                <b>Score: </b>
                <span>
                    {calcScore(total, goal)}
                </span>
            </div>
        </div>
    );
};