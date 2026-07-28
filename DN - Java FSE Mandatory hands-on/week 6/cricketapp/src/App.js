import React from 'react';
import { ListofPlayers, Scorebelow70 } from './Components/ListofPlayers';
import { OddPlayers, EvenPlayers, IndianPlayers, ListofIndianPlayers } from './Components/IndianPlayers';

/**
 * Root execution component evaluating conditional branches to mount targeted squads.
 */
function App() {
  // Dynamic operational state parameter defining the active presentation layer
  const flag = true;

  // Baseline collection data payload tracking standard player score matrices
  const players = [
    { name: "Jack", score: 50 },
    { name: "Michael", score: 70 },
    { name: "John", score: 40 },
    { name: "Ann", score: 61 },
    { name: "Elisabeth", score: 61 },
    { name: "Sachin", score: 95 },
    { name: "Dhoni", score: 100 },
    { name: "Virat", score: 84 },
    { name: "Jadeja", score: 64 },
    { name: "Raina", score: 75 },
    { name: "Rohit", score: 80 }
  ];

  // Normalized roster tracking indices for positioning and structural extraction
  const IndianTeam = ["Sachin1", "Dhoni2", "Virat3", "Rohit4", "Yuvaraj5", "Raina6"];

  // Implementing control structures to evaluate state layout requests
  if (flag === true) {
    return (
      <div style={{ padding: '20px', fontFamily: 'sans-serif' }}>
        <h1>List of Players</h1>
        <ListofPlayers players={players} />
        <hr />
        <h1>List of Players having Scores Less than 70</h1>
        <Scorebelow70 players={players} />
      </div>
    );
  } else {
    return (
      <div style={{ padding: '20px', fontFamily: 'sans-serif' }}>
        <h1>Odd Players</h1>
        {OddPlayers(IndianTeam)}
        <hr />
        <h1>Even Players</h1>
        {EvenPlayers(IndianTeam)}
        <hr />
        <h1>List of Indian Players Merged:</h1>
        <ListofIndianPlayers IndianPlayers={IndianPlayers} />
      </div>
    );
  }
}

export default App;