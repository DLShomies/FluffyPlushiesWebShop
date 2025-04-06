require 'bunny'
require 'dotenv/load'

connection = Bunny.new(
  host: ENV['RABBITMQ_HOST'],
  port: ENV['RABBITMQ_PORT'],
  user: ENV['RABBITMQ_USER'],
  password: ENV['RABBITMQ_PASSWORD']
)
connection.start

CHANNEL = connection.create_channel
