import React from 'react';

/**
 * Presentation component mapping out structural book dataset price parameters.
 */
export const BookDetails = ({ books }) => {
    return (
        <ul style={{ listStyleType: 'none', padding: 0, margin: 0 }}>
            {books.map((book) => (
                <div key={book.id} style={{ marginBottom: '30px' }}>
                    <h2 style={{ margin: '10px 0 5px 0', fontWeight: 'bold', fontSize: '1.75rem' }}>{book.bname}</h2>
                    <h4 style={{ margin: '5px 0', color: '#333', fontSize: '1.1rem', fontWeight: 'normal' }}>{book.price}</h4>
                </div>
            ))}
        </ul>
    );
};