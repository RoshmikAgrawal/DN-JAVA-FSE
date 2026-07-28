import React from 'react';

/**
 * Action component presenting user entry trigger boundaries.
 * Binds external click callback events passed down via properties.
 */
export function LoginButton(props) {
    return (
        <button onClick={props.onClick} style={{ padding: '6px 12px', cursor: 'pointer' }}>
            Login
        </button>
    );
}

/**
 * Action component presenting session termination boundaries.
 * Binds external click callback events passed down via properties.
 */
export function LogoutButton(props) {
    return (
        <button onClick={props.onClick} style={{ padding: '6px 12px', cursor: 'pointer' }}>
            Logout
        </button>
    );
}