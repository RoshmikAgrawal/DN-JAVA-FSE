/**
 * Plain JavaScript data model class representing an individual Blog Post record.
 * Maps out core properties parsed directly from backend network payload objects.
 */
class Post {
    constructor(id, title, body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }
}

export default Post;