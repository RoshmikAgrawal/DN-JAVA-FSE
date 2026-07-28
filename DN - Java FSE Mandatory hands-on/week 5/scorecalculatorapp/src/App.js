//exercise 3
import React from 'react';
import { CalculateScore } from './Components/CalculateScore';

/**
 * Main application dashboard wrapper seeding operational prop parameters
 */
function App() {
  return (
    <div>
      <CalculateScore
        Name={"Steeve"}
        School={"DNV Public School"}
        total={284}
        goal={3}
      />
    </div>
  );
}

export default App;
