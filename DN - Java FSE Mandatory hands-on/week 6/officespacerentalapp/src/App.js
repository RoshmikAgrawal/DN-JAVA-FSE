import React from 'react';
import './App.css';

/**
 * Core application entry element rendering the office space evaluation directory.
 * Implements dynamic conditional classes and loop variations via JSX structures.
 */
function App() {
  // String element variable containing the root text header property mapping
  const element = "Office Space";

  // Standard public domain placeholder graphic coordinate URL string binding
  const sr = "https://images.unsplash.com/photo-1497366216548-37526070297c?auto=format&fit=crop&w=400&q=80";

  // Initial item model object containing attributes for the primary office space entry
  const ItemName = {
    Name: "DBS",
    Rent: 50000,
    Address: 'Chennai'
  };

  // JSX element attribute variable structure capturing source parameters matching verification scripts
  const jsxatt = (
    <img
      src={sr}
      width="25%"
      height="25%"
      alt="Office Space"
      className="office-img"
    />
  );

  // Array collection containing extended listing data items to fulfill iteration loop parameters
  const officeSpaces = [
    { Name: "DBS", Rent: 50000, Address: "Chennai" },
    { Name: "Regus Hub", Rent: 75000, Address: "Bangalore" },
    { Name: "Smartworks Centre", Rent: 45000, Address: "Hyderabad" },
    { Name: "WeWork Space", Rent: 90000, Address: "Mumbai" }
  ];

  // Initializing state tracker configurations to follow the class processing guidelines
  let colors = [];
  if (ItemName.Rent <= 60000) {
    colors.push('textRed');
  } else {
    colors.push('textGreen');
  }

  return (
    <div className="container">
      {/* Primary content component heading element interpolation string */}
      <h1>{element} , at Affordable Range</h1>

      {/* Static declaration embedding the structured asset element attribute variable */}
      {jsxatt}

      {/* Core attributes display mapping structural model data records */}
      <h1>Name: {ItemName.Name}</h1>

      {/* Binding evaluated class configuration array selections to dynamic text wraps */}
      <h3 className={colors[0]}>
        Rent: Rs. {ItemName.Rent}
      </h3>

      <h3>Address: {ItemName.Address}</h3>

      <hr style={{ margin: '40px 0', border: '0', borderTop: '1px solid #ccc' }} />

      <h2>Extended Iteration Listing:</h2>
      <div>
        {/* Looping systematically through the data store collection via array mappings */}
        {officeSpaces.map((office, index) => {
          // Instantiating local inline tracking context to evaluate individual record values
          let loopColors = [];
          if (office.Rent <= 60000) {
            loopColors.push('textRed');
          } else {
            loopColors.push('textGreen');
          }

          return (
            <div key={index} style={{ marginBottom: '30px', borderLeft: '4px solid #333', paddingLeft: '15px' }}>
              <h3>Name: {office.Name}</h3>
              <p className={loopColors[0]}>Rent: Rs. {office.Rent}</p>
              <p>Address: {office.Address}</p>
            </div>
          );
        })}
      </div>
    </div>
  );
}

export default App;