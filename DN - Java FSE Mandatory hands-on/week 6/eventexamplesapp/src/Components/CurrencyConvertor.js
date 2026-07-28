import React, { Component } from 'react';

/**
 * Component handling evaluation forms and mathematical conversion actions.
 * Extracts textual metrics to safely compute asset valuations under strict transaction contexts.
 */
class CurrencyConvertor extends Component {
    constructor(props) {
        super(props);
        // Tracking independent input parameters inside localized states
        this.state = {
            amount: '',
            currency: ''
        };

        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    /**
     * Dynamic state synchronizer updating entries using standard target identity properties.
     * @param {Object} event - The synthetic alteration event capturing the current input stream.
     */
    handleInputChange(event) {
        const { name, value } = event.target;
        this.setState({
            [name]: value
        });
    }

    /**
     * Intercepts form submittals, prevents page refreshes, and evaluates conversions.
     * @param {Object} event - Form submission event handler container.
     */
    handleSubmit(event) {
        event.preventDefault();
        const { amount, currency } = this.state;

        // Parsing values to execute numerical conversion transformations
        const numericAmount = parseFloat(amount) || 0;
        const convertedAmount = numericAmount * 80;

        alert(`Converting to ${currency} Amount is ${convertedAmount}`);
    }

    render() {
        return (
            <div>
                {/* Standard heading element matching lab stylistic specs */}
                <h1 style={{ color: 'green', fontFamily: 'sans-serif' }}>Currency Convertor!!!</h1>

                <form onSubmit={this.handleSubmit} style={{ fontFamily: 'sans-serif' }}>
                    <div style={{ marginBottom: '10px' }}>
                        <label style={{ inlineBlock: 'true', width: '80px', display: 'inline-block' }}>Amount:</label>
                        <input
                            type="number"
                            name="amount"
                            value={this.state.amount}
                            onChange={this.handleInputChange}
                        />
                    </div>
                    <div style={{ marginBottom: '10px', display: 'flex', alignItems: 'flex-start' }}>
                        <label style={{ width: '80px', display: 'inline-block' }}>Currency:</label>
                        <textarea
                            name="currency"
                            rows="1"
                            value={this.state.currency}
                            onChange={this.handleInputChange}
                            style={{ width: '150px', height: '30px', resize: 'none' }}
                        />
                    </div>
                    <div style={{ marginLeft: '80px' }}>
                        <button type="submit">Submit</button>
                    </div>
                </form>
            </div>
        );
    }
}

export default CurrencyConvertor;