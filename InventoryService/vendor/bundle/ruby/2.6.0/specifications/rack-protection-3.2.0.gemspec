# -*- encoding: utf-8 -*-
# stub: rack-protection 3.2.0 ruby lib

Gem::Specification.new do |s|
  s.name = "rack-protection".freeze
  s.version = "3.2.0"

  s.required_rubygems_version = Gem::Requirement.new(">= 0".freeze) if s.respond_to? :required_rubygems_version=
  s.metadata = { "documentation_uri" => "https://www.rubydoc.info/gems/rack-protection", "homepage_uri" => "http://sinatrarb.com/protection/", "rubygems_mfa_required" => "true", "source_code_uri" => "https://github.com/sinatra/sinatra/tree/main/rack-protection" } if s.respond_to? :metadata=
  s.require_paths = ["lib".freeze]
  s.authors = ["https://github.com/sinatra/sinatra/graphs/contributors".freeze]
  s.date = "2023-12-29"
  s.description = "Protect against typical web attacks, works with all Rack apps, including Rails".freeze
  s.email = "sinatrarb@googlegroups.com".freeze
  s.homepage = "https://sinatrarb.com/protection/".freeze
  s.licenses = ["MIT".freeze]
  s.required_ruby_version = Gem::Requirement.new(">= 2.6.0".freeze)
  s.rubygems_version = "3.0.3.1".freeze
  s.summary = "Protect against typical web attacks, works with all Rack apps, including Rails.".freeze

  s.installed_by_version = "3.0.3.1" if s.respond_to? :installed_by_version

  if s.respond_to? :specification_version then
    s.specification_version = 4

    if Gem::Version.new(Gem::VERSION) >= Gem::Version.new('1.2.0') then
      s.add_runtime_dependency(%q<base64>.freeze, [">= 0.1.0"])
      s.add_runtime_dependency(%q<rack>.freeze, ["~> 2.2", ">= 2.2.4"])
    else
      s.add_dependency(%q<base64>.freeze, [">= 0.1.0"])
      s.add_dependency(%q<rack>.freeze, ["~> 2.2", ">= 2.2.4"])
    end
  else
    s.add_dependency(%q<base64>.freeze, [">= 0.1.0"])
    s.add_dependency(%q<rack>.freeze, ["~> 2.2", ">= 2.2.4"])
  end
end
