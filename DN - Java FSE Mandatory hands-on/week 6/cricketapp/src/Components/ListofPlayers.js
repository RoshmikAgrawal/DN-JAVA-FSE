import React from 'react';

/**
 * Functional component rendering the baseline collection of players.
 * Demonstrates the implementation of the ES6 array map method for transformation.
 */
export const ListofPlayers = ({ players }) => {
    return (
        <ul>
            {players.map((item, index) => (
                <div key={index}>
                    <li>Mr. {item.name} <span>{item.score}</span></li>
                </div>
            ))}
        </ul>
    );
};

/**
 * Functional component filtering and rendering a subset of players.
 * Leverages inline arrow function predicates to filter scores structurally.
 */
export const Scorebelow70 = ({ players }) => {
    const players70 = [];

    // Iterating and isolating records matching the filtering threshold criteria
    players.map((item) => {
        if (item.score <= 70) {
            players70.push(item);
        }
        return null;
    });

    return (
        <ul>
            {players70.map((item, index) => (
                <div key={index}>
                    <li>Mr. {item.name}</li>
                </div>
            ))}
        </ul>
    );
};