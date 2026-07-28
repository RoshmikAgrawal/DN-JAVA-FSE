import React from 'react';
import { BookDetails } from './Components/BookDetails';
import { BlogDetails } from './Components/BlogDetails';
import { CourseDetails } from './Components/CourseDetails';

/**
 * Root execution controller managing database collections and inline layout rendering rules.
 */
function App() {
  // Roster arrays tracking the baseline course timeline datasets
  const courses = [
    { id: 201, cname: 'Angular', date: '4/5/2021' },
    { id: 202, cname: 'React', date: '6/3/2021' }
  ];

  // Roster arrays tracking the baseline book price datasets
  const books = [
    { id: 101, bname: 'Master React', price: 670 },
    { id: 102, bname: 'Deep Dive into Angular 11', price: 800 },
    { id: 103, bname: 'Mongo Essentials', price: 450 }
  ];

  // Roster arrays tracking public web log article datasets
  const blogs = [
    { id: 301, title: 'React Learning', author: 'Stephen Biz', body: 'Welcome to learning React!' },
    { id: 302, title: 'Installation', author: 'Schewzdenier', body: 'You can install React from npm.' }
  ];

  // Condition state identifier setting structural module generation behaviors
  const showModules = true;

  // Instantiating element variable blocks to process structural sub-views conditionally
  let coursedet = null;
  let bookdet = null;
  let content = null;

  // Parsing control statements to evaluate current layout injection mappings
  if (showModules) {
    coursedet = <CourseDetails courses={courses} />;
    bookdet = <BookDetails books={books} />;
    content = <BlogDetails blogs={blogs} />;
  }

  return (
    /* Outer flex matrix forcing all column children elements to line up horizontally in a row */
    <div style={{ display: 'flex', flexDirection: 'row', justifyContent: 'space-around', alignItems: 'flex-start', padding: '40px', fontFamily: 'sans-serif' }}>

      {/* Left Presentation Grid Column: Course Details */}
      <div style={{ flex: 1, padding: '0 20px', textAlign: 'center' }}>
        <h1 style={{ fontWeight: 'bold', fontSize: '2.2rem', marginBottom: '20px' }}>Course Details</h1>
        {coursedet}
      </div>

      {/* Solid Column Separation Boundary: Green Vertical Line */}
      <div style={{ borderLeft: '5px solid green', height: '520px', margin: '0 15px', alignSelf: 'center' }}></div>

      {/* Middle Presentation Grid Column: Book Details */}
      <div style={{ flex: 1, padding: '0 20px', textAlign: 'center' }}>
        <h1 style={{ fontWeight: 'bold', fontSize: '2.2rem', marginBottom: '20px' }}>Book Details</h1>
        {bookdet}
      </div>

      {/* Solid Column Separation Boundary: Green Vertical Line */}
      <div style={{ borderLeft: '5px solid green', height: '520px', margin: '0 15px', alignSelf: 'center' }}></div>

      {/* Right Presentation Grid Column: Blog Details */}
      <div style={{ flex: 1, padding: '0 20px', textAlign: 'center' }}>
        <h1 style={{ fontWeight: 'bold', fontSize: '2.2rem', marginBottom: '20px' }}>Blog Details</h1>
        {content}
      </div>

    </div>
  );
}

export default App;