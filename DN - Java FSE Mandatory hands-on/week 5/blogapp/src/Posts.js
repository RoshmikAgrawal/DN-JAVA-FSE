import React from 'react';
import Post from './Post';

/**
 * Class-based component orchestrating asynchronous network data loading pipelines.
 * Intercepts standard application render lifecycles via core framework hook structures.
 */
class Posts extends React.Component {
    constructor(props) {
        super(props);
        // Initialize the state object layout with an empty post dataset registry
        this.state = {
            posts: []
        };
    }

    /**
     * Utilizes native global Fetch API interfaces to query mock rest server endpoints .
     * Parses payload listings directly into structured local Post entity model instances .
     */
    loadPosts() {
        fetch('https://jsonplaceholder.typicode.com/posts')
            .then(response => {
                if (!response.ok) {
                    throw new Error("Failed to communicate successfully with external REST API.");
                }
                return response.json();
            })
            .then(data => {
                // Instantiate clean Post objects using properties loaded from the data stream 
                const mappedPosts = data.map(item => new Post(item.id, item.title, item.body));
                this.setState({ posts: mappedPosts });
            })
            .catch(error => {
                // Manually force an execution exception loop to allow componentDidCatch to process it 
                this.componentDidCatch(error, error.stack);
            });
    }

    /**
     * Standard lifecycle hook automatically invoked after component injection variants complete .
     * Establishes the ideal location to perform initial REST API data retrieval routines .
     */
    componentDidMount() {
        this.loadPosts();
    }

    /**
     * Specialized validation hook intercepting structural runtime breaks across the tree context .
     * Prevents visual interface crashes by formatting error parameters into alert windows .
     */
    componentDidCatch(error, info) {
        alert("Lifecycle Error Log Captured: " + error.message);
    }

    /**
     * Evaluates active collection variables to systematically render dynamic templates .
     * Outputs post identities using distinct title headings and body text paragraph tags .
     */
    render() {
        return (
            <div style={{ padding: '20px', maxWidth: '800px', margin: '0 auto', fontFamily: 'sans-serif' }}>
                <h1 style={{ textAlign: 'center', borderBottom: '2px solid #333', paddingBottom: '10px' }}>
                    JSONPlaceholder Blog Network
                </h1>
                {this.state.posts.map(post => (
                    <div key={post.id} style={{ margin: '20px 0', padding: '15px', background: '#f5f5f5', borderRadius: '8px' }}>
                        {/* Render titles inside standard structural headings  */}
                        <h2 style={{ color: '#2c3e50', textTransform: 'capitalize' }}>{post.title}</h2>
                        {/* Render individual article copy parameters inside dedicated paragraph wrappers  */}
                        <p style={{ color: '#34495e', lineHeight: '1.6' }}>{post.body}</p>
                    </div>
                ))}
            </div>
        );
    }
}

export default Posts;