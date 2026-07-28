import React from 'react';
import CounterEvents from './Components/CounterEvents';
import CurrencyConvertor from './Components/CurrencyConvertor';

/**
 * Baseline composition layout uniting event trackers and calculation forms.
 */
function App() {
  return (
      <div style={{ padding: '30px' }}>
        <CounterEvents />
        <CurrencyConvertor />
      </div>
  );
}

export default App;