import React from 'react';

/**
 * Extracts and displays designated odd-positioned players from the array context.
 * Utilizes array destructuring syntax with empty commas to selectively bind odd indices.
 */
export function OddPlayers([first, , third, , fifth]) {
    return (
        <div>
            <ul>
                <li>First : {first}</li>
                <li>Third : {third}</li>
                <li>Fifth : {fifth}</li>
            </ul>
        </div>
    );
}

/**
 * Extracts and displays designated even-positioned players from the array context.
 * Utilizes array destructuring syntax with a leading comma to selectively bind even indices.
 */
export function EvenPlayers([, second, , fourth, , sixth]) {
    return (
        <div>
            <ul>
                <li>Second : {second}</li>
                <li>Fourth : {fourth}</li>
                <li>Sixth : {sixth}</li>
            </ul>
        </div>
    );
}

// Defining local structural arrays to establish individual squad listings
const T20Players = ['First Player', 'Second Player', 'Third Player'];
const RanjiTrophyPlayers = ['Fourth Player', 'Fifth Player', 'Sixth Player'];

// Executing immutable array merging operations via the ES6 spread operator
export const IndianPlayers = [...T20Players, ...RanjiTrophyPlayers];

/**
 * Functional component rendering the consolidated listing of merged player groups.
 */
export const ListofIndianPlayers = ({ IndianPlayers }) => {
    return (
        <ul>
            {IndianPlayers.map((player, index) => (
                <li key={index}>Mr. {player}</li>
            ))}
        </ul>
    );
};