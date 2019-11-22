#!/usr/bin/env python

from flask import Flask, jsonify

app = Flask(__name__)

@app.route('/hello', methods=['GET'])
def get_tasks():
    return jsonify({"hello":"world"})

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', port=9999)