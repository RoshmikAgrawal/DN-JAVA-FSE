import React, { Component } from 'react';

/**
 * Class-based component managing foundational user input and click interaction events.
 * Demonstrates state management, explicit execution context binding, and multi-method triggers.
 */
class CounterEvents extends Component {
    constructor(props) {
        super(props);
        // Initializing the counter state parameter context
        this.state = {
            counter: 5
        };

        // Explicitly binding execution contexts to secure the runtime reference pipeline
        this.handleIncrement = this.handleIncrement.bind(this);
        this.handleDecrement = this.handleDecrement.bind(this);
        this.sayHello = this.sayHello.bind(this);
        this.handleSayWelcome = this.handleSayWelcome.bind(this);
        this.handleSyntheticEvent = this.handleSyntheticEvent.bind(this);
    }

    /**
     * Secondary method responsible for displaying static registration notifications.
     */
    sayHello() {
        alert("Hello! Member1");
    }

    /**
     * Primary event handler orchestrating multi-method triggers upon instantiation.
     * Updates the internal state machine and fires the secondary alert method sequentially.
     */
    handleIncrement() {
        this.setState(prevState => ({
            counter: prevState.counter + 1
        }));
        this.sayHello();
    }

    /**
     * Decrements the numerical state counter tracking value.
     */
    handleDecrement() {
        this.setState(prevState => ({
            counter: prevState.counter - 1
        }));
    }

    /**
     * Processes parameter passing within event triggers.
     * @param {string} message - The inbound greeting phrase context passed from the template.
     */
    handleSayWelcome(message) {
        alert(message);
    }

    /**
     * Intercepts standard user actions to evaluate the underlying SyntheticEvent envelope.
     * @param {Object} event - The normalized cross-browser event object managed by the framework.
     */
    handleSyntheticEvent(event) {
        alert("I was clicked");
    }

    render() {
        return (
            <div style={{ marginBottom: '30px' }}>
                {/* Visual rendering of the primitive execution state value */}
                <div style={{ fontSize: '20px', marginBottom: '10px' }}>
                    {this.state.counter}
                </div>

                <div style={{ display: 'flex', flexDirection: 'column', width: '120px', gap: '5px' }}>
                    {/* Event hooks utilizing bound execution methods */}
                    <button onClick={this.handleIncrement}>Increment</button>
                    <button onClick={this.handleDecrement}>Decrement</button>

                    {/* Inline arrow handler facilitating parameter passing requirements */}
                    <button onClick={() => this.handleSayWelcome("welcome")}>Say welcome</button>

                    {/* Direct execution link parsing the synthetic interaction envelope */}
                    <button onClick={this.handleSyntheticEvent}>Click on me</button>
                </div>
            </div>
        );
    }
}

export default CounterEvents;