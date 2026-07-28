import React from 'react';

/**
 * Presentation component looping systematically through individual course schedules via map arrays.
 */
export const CourseDetails = ({ courses }) => {
    return (
        <ul style={{ listStyleType: 'none', padding: 0, margin: 0 }}>
            {courses.map((course) => (
                <div key={course.id} style={{ marginBottom: '30px' }}>
                    <h2 style={{ margin: '10px 0 5px 0', fontWeight: 'bold', fontSize: '1.75rem' }}>{course.cname}</h2>
                    <h4 style={{ margin: '5px 0', color: '#333', fontSize: '1.1rem', fontWeight: 'normal' }}>{course.date}</h4>
                </div>
            ))}
        </ul>
    );
};