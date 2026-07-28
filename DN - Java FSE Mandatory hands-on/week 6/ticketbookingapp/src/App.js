import React, { useState } from 'react';
import { Greeting } from './Components/Greeting';
import { LoginButton, LogoutButton } from './Components/AuthButtons';

/**
 * Core application shell governing layout flows and authentication states.
 * Employs state containers to update active components dynamically.
 */
function App() {
  // Initializing the boolean state tracker for authentication monitoring
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  // Event handler to transition state context to authenticated status
  const handleLoginClick = () => {
    setIsLoggedIn(true);
  };

  // Event handler to transition state context to unauthenticated guest status
  const handleLogoutClick = () => {
    setIsLoggedIn(false);
  };

  // Utilizing an element variable to conditionally hold the target action button
  let button;
  if (isLoggedIn) {
    button = <LogoutButton onClick={handleLogoutClick} />;
  } else {
    button = <LoginButton onClick={handleLoginClick} />;
  }

  return (
      <div style={{ padding: '40px', fontFamily: 'sans-serif', maxWidth: '600px', margin: '0 auto' }}>
        {/* Injecting the evaluation router component with status mappings */}
        <Greeting isLoggedIn={isLoggedIn} />

        {/* Rendering the dynamically populated element variable */}
        <div style={{ marginTop: '15px' }}>
          {button}
        </div>
      </div>
  );
}

export default App;