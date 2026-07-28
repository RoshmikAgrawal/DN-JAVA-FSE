import React from 'react';

/**
 * Functional component rendering the view tailored for authenticated users.
 * Displays greeting message and grants access to ticket booking actions.
 */
function UserGreeting() {
    return (
        <div>
            <h1>Welcome back</h1>
            <div style={{ marginTop: '20px', padding: '15px', background: '#e8f5e9', borderRadius: '5px' }}>
                <h3>Flight Booking Portal</h3>
                <p>Select your destination and click below to reserve your seats.</p>
                <button style={{ backgroundColor: '#2e7d32', color: 'white', padding: '8px 16px', border: 'none', borderRadius: '4px', cursor: 'pointer' }}>
                    Book Tickets Now
                </button>
            </div>
        </div>
    );
}

/**
 * Functional component rendering the view tailored for guest visitors.
 * Displays sign-up prompts and restricts activities to flight data browsing only.
 */
function GuestGreeting() {
    return (
        <div>
            <h1>Please sign up.</h1>
            <div style={{ marginTop: '20px', padding: '15px', background: '#e3f2fd', borderRadius: '5px' }}>
                <h3>Available Flight Schedules (Browsing Mode)</h3>
                <ul>
                    <li>Flight AA-102: Delhi to Mumbai - 14:00 hrs</li>
                    <li>Flight BA-204: Bengaluru to Chennai - 17:30 hrs</li>
                    <li>Flight CA-306: Kolkata to Hyderabad - 21:15 hrs</li>
                </ul>
                <p style={{ color: '#d32f2f', fontSize: '14px' }}>*Please log in to purchase tickets.</p>
            </div>
        </div>
    );
}

/**
 * Main evaluation router determining which sub-view to execute.
 * Intercepts properties to conditionally mount the target component.
 */
export function Greeting(props) {
    const isLoggedIn = props.isLoggedIn;
    if (isLoggedIn) {
        return <UserGreeting />;
    }
    return <GuestGreeting />;
}