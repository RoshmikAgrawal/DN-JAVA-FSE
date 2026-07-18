// exercise 2
import React from 'react';
import './App.css';
import { Home } from './Components/Home';
import { About } from './Components/About';
import { Contact } from './Components/Contact';

/**
 * Root execution component organizing the multi-view single page dashboard structure[cite: 2, 3].
 */
function App() {
  return (
    <div className="container" style={{ padding: '20px', textAlign: 'center' }}>
      <Home />
      <About />
      <Contact />
    </div>
  );
}

export default App;