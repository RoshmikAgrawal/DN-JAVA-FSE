import React from 'react';

/**
 * Presentation component handling specific blog summary data fields[cite: 10].
 */
export const BlogDetails = ({ blogs }) => {
    return (
        <ul style={{ listStyleType: 'none', padding: 0, margin: 0 }}>
            {blogs.map((blog) => (
                <div key={blog.id} style={{ marginBottom: '30px' }}>
                    <h2 style={{ margin: '10px 0 5px 0', fontWeight: 'bold', fontSize: '1.75rem' }}>{blog.title}</h2>
                    <h4 style={{ margin: '5px 0', color: '#000', fontSize: '1.1rem', fontWeight: 'bold' }}>{blog.author}</h4>
                    <p style={{ margin: '5px 0', color: '#555', fontSize: '1.05rem', lineHeight: '1.4' }}>{blog.body}</p>
                </div>
            ))}
        </ul>
    );
};